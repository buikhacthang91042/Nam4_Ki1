using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace UT_Lab_3
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\Data_UTLab3.csv", "Data_UTLab3#csv", DataAccessMethod.Sequential), DeploymentItem("Data_UTLab3.csv"), TestMethod]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int chiSoCu = int.Parse(TestContext.DataRow[0].ToString());
            int chiSoMoi = int.Parse(TestContext.DataRow[1].ToString());
            Double act = o.TinhTienDien(chiSoCu, chiSoMoi);
            double exp = Double.Parse(TestContext.DataRow[2].ToString());
            Assert.AreEqual(exp, act);
        }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataError_UTLab3.csv", "DataError_UTLab3#csv", DataAccessMethod.Sequential), DeploymentItem("DataError_UTLab3.csv"), TestMethod]
        public void TestMethod2()
        {
            Exception expectedException = null;
            try
            {
                MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
                int chiSoCu = int.Parse(TestContext.DataRow[0].ToString());
                int chiSoMoi = int.Parse(TestContext.DataRow[1].ToString());
                double act = o.TinhTienDien(chiSoCu, chiSoMoi);
            }
            catch (Exception ex)
            {
                // Catches the exception
                expectedException = ex;
            }
            Assert.IsNotNull(expectedException);
        }
    }
}

using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace UT_Lab_2
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\Data_UTLab2.csv", "Data_UTLab2#csv", DataAccessMethod.Sequential), DeploymentItem("Data_UTLab2.csv"), TestMethod]

        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int a = int.Parse(TestContext.DataRow[0].ToString());
            int b = int.Parse(TestContext.DataRow[1].ToString());
            int c = int.Parse(TestContext.DataRow[2].ToString());
            string exp = TestContext.DataRow[3].ToString();
            float x1, x2;
            string act = o.SolveQuadratic(a, b, c, out x1, out x2);
            Assert.AreEqual(exp, act);
        }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataError_UTLab2.csv", "DataError_UTLab2#csv", DataAccessMethod.Sequential), DeploymentItem("DataError_UTLab2.csv"), TestMethod]
        public void TestMethod2()
        {
            Exception expectedException = null;
            try
            {
                MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
                int a = int.Parse(TestContext.DataRow[0].ToString());
                int b = int.Parse(TestContext.DataRow[1].ToString());
                int c = int.Parse(TestContext.DataRow[2].ToString());
                float x1, x2;
                string act = o.SolveQuadratic(a, b, c, out x1, out x2);
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

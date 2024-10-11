using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace UT_Lab_5
{
    [TestClass]
    public class UnitTest1
    {

        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\Data_UTLab5.csv", "Data_UTLab5#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("Data_UTLab5.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();

            string s = TestContext.DataRow[0].ToString();
            int n = int.Parse(TestContext.DataRow[1].ToString());
            int p = int.Parse(TestContext.DataRow[2].ToString());

            string r = o.HuyChuoi(s, n, p);
            string exp = TestContext.DataRow[3].ToString();
            Assert.AreEqual(exp, r);
        }

        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataError_UTLab5.csv", "DataError_UTLab5#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("DataError_UTLab5.csv")]
        public void TestMethod2()
        {
            Exception expectedException = null;
            try
            {
                MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
                string s = TestContext.DataRow[0].ToString();
                int n = int.Parse(TestContext.DataRow[1].ToString());
                int p = int.Parse(TestContext.DataRow[2].ToString());
                string r = o.HuyChuoi(s, n, p);
            }
            catch (Exception ex)
            {
                expectedException = ex;
            }
            Assert.IsNotNull(expectedException);
        }


    }
}

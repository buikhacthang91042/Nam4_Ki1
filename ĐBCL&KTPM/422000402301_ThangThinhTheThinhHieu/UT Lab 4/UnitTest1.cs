using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace UT_Lab_4
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\Data_UTLab4.csv", "Data_UTLab4#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("Data_UTLab4.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            long s0 = long.Parse(TestContext.DataRow[0].ToString());
            long expected_s = long.Parse(TestContext.DataRow[1].ToString());
            long expected_k = long.Parse(TestContext.DataRow[2].ToString());
            long act = o.Sum(s0, out expected_s);
            Assert.AreEqual(act, expected_s, expected_k);
            
            
        }

        [TestMethod()]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataError_UTLab4.csv", "DataError_UTLab4#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("DataError_UTLab4.csv")]
        public void TestMethod2()
        {
            Exception expectedException = null;
            try
            {
                MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
                long s0 = long.Parse(TestContext.DataRow[0].ToString());
                long expected_s = long.Parse(TestContext.DataRow[1].ToString());
                long act = o.Sum(s0, out expected_s);
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
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace UT_Lab_1
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\Data_UTLab1.csv", "Data_UTLab1#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("Data_UTLab1.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int A = Int32.Parse(TestContext.DataRow[0].ToString());
            int B = Int32.Parse(TestContext.DataRow[1].ToString());
            int C = Int32.Parse(TestContext.DataRow[2].ToString());
            int expected_result = Int32.Parse(TestContext.DataRow[3].ToString());
            int act = o.Max(A, B, C);
            Assert.AreEqual(act, expected_result);
        }

        [TestMethod()]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataError_UTLab1.csv", "DataError_UTLab1#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("DataError_UTLab1.csv")]
        public void TestMethod2()
        {
            Exception expectedException = null;
            try
            {
                MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
                int A = Int32.Parse(TestContext.DataRow[0].ToString());
                int B = Int32.Parse(TestContext.DataRow[1].ToString());
                int C = Int32.Parse(TestContext.DataRow[2].ToString());
                int expected_result = Int32.Parse(TestContext.DataRow[3].ToString());
                int act = o.Max(A, B, C);
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

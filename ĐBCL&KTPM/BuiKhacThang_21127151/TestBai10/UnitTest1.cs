using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace TestBai10
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data10.csv", "data10#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("data10.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = TestContext.DataRow[0].ToString();
            int n = Convert.ToInt32(TestContext.DataRow[1].ToString());
            int p = Convert.ToInt32(TestContext.DataRow[2].ToString());
            String expected = TestContext.DataRow[3].ToString();
            String act = o.HuyChuoi(s, n, p);
            Assert.AreEqual(expected, act);
        }
    }
}

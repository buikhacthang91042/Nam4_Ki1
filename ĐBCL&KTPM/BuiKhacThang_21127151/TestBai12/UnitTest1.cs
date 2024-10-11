using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace TestBai12
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data12.csv", "data12#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("data12.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            string[] stringArray = TestContext.DataRow[0].ToString().Split(',');
            int[] a = Array.ConvertAll(TestContext.DataRow[0].ToString(), int.Parse);
            int expected = Convert.ToInt32(TestContext.DataRow[1].ToString());
            int act = o.Largest(a);
            Assert.AreEqual(expected, act);
        }
    }
}

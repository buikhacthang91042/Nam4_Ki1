using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace TestBai01
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data.csv", "data#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("data.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int number   = Convert.ToInt32((TestContext.DataRow[0]).ToString());
            bool expected = Convert.ToBoolean((TestContext.DataRow[1]).ToString());
            bool act = o.primeCheck(number);
            Assert.AreEqual(expected, act);
        }
    }
}

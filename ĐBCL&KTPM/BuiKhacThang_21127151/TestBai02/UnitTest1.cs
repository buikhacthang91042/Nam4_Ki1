using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace TestBai02
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data04.csv", "data04#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("data04.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int year = Convert.ToInt32((TestContext.DataRow[0]).ToString());
            bool expected = Convert.ToBoolean((TestContext.DataRow[1]).ToString());
            bool act = o.IsLeapYear(year);
            Assert.AreEqual(expected, act);
        }
    }
}

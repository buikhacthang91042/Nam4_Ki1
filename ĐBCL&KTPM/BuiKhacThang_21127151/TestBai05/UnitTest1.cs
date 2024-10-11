using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace TestBai05
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data05.csv", "data05#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("data05.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String sbin = TestContext.DataRow[0].ToString();
            long expected = Convert.ToInt64((TestContext.DataRow[1]).ToString());
            long act = o.BinToDec(sbin);
            Assert.AreEqual(expected, act);
        }
    }
}

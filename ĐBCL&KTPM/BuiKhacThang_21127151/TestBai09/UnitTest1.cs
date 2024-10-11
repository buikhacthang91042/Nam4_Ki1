using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace TestBai09
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data09.csv", "data09#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("data09.csv")]
        public void TestMethod1()
        {
           MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            long s0 = Convert.ToInt64(TestContext.DataRow[0].ToString());
            long expected_s = Convert.ToInt64(TestContext.DataRow[1].ToString());
            long expected_k = Convert.ToInt64(TestContext.DataRow[2].ToString());
            long act_k = o.Sum(s0, out long act_s);
            Assert.AreEqual(expected_s, act_s);
            Assert.AreEqual(expected_k, act_k);
        }
    }
}

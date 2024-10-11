using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace TestBai11
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data11.csv", "data11#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("data11.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1 = TestContext.DataRow[0].ToString();
            String s2 = TestContext.DataRow[1].ToString();
            String s3 = TestContext.DataRow[2].ToString();
            String expected = TestContext.DataRow[3].ToString();
            String act = o.ThayThe(s1,s2,s3);
            Assert.AreEqual(expected, act);
        }
    }
}

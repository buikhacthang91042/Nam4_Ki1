using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace TestBai07
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data07.csv", "data07#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("data07.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int a = Convert.ToInt32(TestContext.DataRow[0].ToString());
            int b = Convert.ToInt32(TestContext.DataRow[1].ToString());
            int c = Convert.ToInt32(TestContext.DataRow[2].ToString());
            String expected = TestContext.DataRow[3].ToString();
            String act = o.SolveQuadratic(a,b,c,out float x1, out float x2);
            Assert.AreEqual(expected, act);
        }
    }
}

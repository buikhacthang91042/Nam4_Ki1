using ClassLibrary_Module03;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace UnitTestBai10
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai10.csv", "DataBai10#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai10.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            float a = float.Parse(TestContext.DataRow[0].ToString());
            float b = float.Parse(TestContext.DataRow[1].ToString());
            float c = float.Parse(TestContext.DataRow[2].ToString());
            bool exp = bool.Parse(TestContext.DataRow[3].ToString());
            bool act = cls.IsValidTriangle(a, b, c);
            Assert.AreEqual(exp, act);
        }
    }
}

using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTestBai14
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai14.csv", "DataBai14#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai14.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            float w = float.Parse(TestContext.DataRow[0].ToString());
            float h = float.Parse(TestContext.DataRow[1].ToString());
            string expected = TestContext.DataRow[2].ToString();
            string actual = cls.TaoMotIcon(w, h);
            Assert.AreEqual(expected, actual);
        }
    }
}

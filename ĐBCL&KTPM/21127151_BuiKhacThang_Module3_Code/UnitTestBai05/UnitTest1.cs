using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTestBai05
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai5.csv", "DataBai5#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai5.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            int a = int.Parse(TestContext.DataRow[0].ToString());
            int b = int.Parse(TestContext.DataRow[1].ToString());
            int c = int.Parse(TestContext.DataRow[2].ToString());
            string expected = TestContext.DataRow[3].ToString();
            string act = cls.Triangle(a, b, c);
            Assert.AreEqual(expected, act);
        }
    }
}

using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTestBai1
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai1.csv", "DataBai1#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai1.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            int firstRadius = int.Parse(TestContext.DataRow[0].ToString());
            int secRadius = int.Parse(TestContext.DataRow[1].ToString());
            int distance = int.Parse(TestContext.DataRow[2].ToString());
            int expected = int.Parse(TestContext.DataRow[3].ToString());
            int actual = cls.getPositionOf2Cir(firstRadius, secRadius,distance);
            Assert.AreEqual(expected, actual);
        }
    }
}

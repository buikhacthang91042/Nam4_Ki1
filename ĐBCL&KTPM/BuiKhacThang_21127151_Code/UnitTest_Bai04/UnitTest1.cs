using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTest_Bai04
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai4.csv", "DataBai4#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai4.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            int a = int.Parse(TestContext.DataRow[0].ToString());
            int b = int.Parse(TestContext.DataRow[1].ToString());
            int c = int.Parse(TestContext.DataRow[2].ToString());
            int expected = int.Parse(TestContext.DataRow[3].ToString());
            int actual = cls.Max(a, b, c);
            Assert.AreEqual(expected, actual);
        }
    }
}

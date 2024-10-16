using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTestBai12
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai12.csv", "DataBai12#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai12.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            double total = double.Parse(TestContext.DataRow[0].ToString());
            double p1 = double.Parse(TestContext.DataRow[1].ToString());
            double p2 = double.Parse(TestContext.DataRow[2].ToString());
            double p3 = double.Parse(TestContext.DataRow[3].ToString());
            string expected = TestContext.DataRow[4].ToString();
            string actual = cls.TinhGiaNhieuMuc(total, p1, p2, p3);
            Assert.AreEqual(expected, actual);
        }
    }
}

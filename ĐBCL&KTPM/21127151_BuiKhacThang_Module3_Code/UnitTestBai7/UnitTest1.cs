using ClassLibrary_Module03;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTestBai7
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai7.csv", "DataBai7#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai7.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            int year = int.Parse(TestContext.DataRow[0].ToString());
            int month = int.Parse(TestContext.DataRow[1].ToString());
            int exp = int.Parse(TestContext.DataRow[2].ToString());
            int act = cls.DaysInMonth(year, month);
            Assert.AreEqual(exp, act);
        }
    }
}

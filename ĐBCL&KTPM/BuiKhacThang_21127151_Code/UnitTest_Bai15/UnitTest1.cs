using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTest_Bai15
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai15.csv", "DataBai15#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai15.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            int year = int.Parse(TestContext.DataRow[0].ToString());
            bool exp = bool.Parse(TestContext.DataRow[1].ToString());
            bool act = cls.IsLeapYear(year);
            Assert.AreEqual(exp, act);
        }
    }
}

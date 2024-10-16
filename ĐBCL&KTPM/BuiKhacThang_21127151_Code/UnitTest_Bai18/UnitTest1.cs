using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTest_Bai18
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai18.csv", "DataBai18#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai18.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            string email = TestContext.DataRow[0].ToString();
            bool expected = bool.Parse(TestContext.DataRow[1].ToString());
            bool act = cls.EmailCheck(email);
            Assert.AreEqual(expected, act);
        }
    }
}

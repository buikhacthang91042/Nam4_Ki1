using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTestBai16
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai16.csv", "DataBai16#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai16.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            String password = TestContext.DataRow[0].ToString();
            bool exp = bool.Parse(TestContext.DataRow[1].ToString());
            bool act=  cls.PasswordCheck(password);
            Assert.AreEqual(exp, act);
        }
    }
}

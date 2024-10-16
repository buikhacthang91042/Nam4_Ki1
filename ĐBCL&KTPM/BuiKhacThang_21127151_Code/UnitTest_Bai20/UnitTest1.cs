using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTest_Bai20
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai20.csv", "DataBai20#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai20.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            char tmp = char.Parse(TestContext.DataRow[0].ToString());
            int expected = int.Parse(TestContext.DataRow[1].ToString());
            int act = cls.isInString(tmp);
            Assert.AreEqual(expected, act);
        }
    }
}

using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTestBai21
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai21.csv", "DataBai21#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai21.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            string hexaString = TestContext.DataRow[0].ToString();
            long expected = long.Parse(TestContext.DataRow[1].ToString());
            long act = cls.HexToDec(hexaString);
            Assert.AreEqual(expected, act);
        }
    }
}

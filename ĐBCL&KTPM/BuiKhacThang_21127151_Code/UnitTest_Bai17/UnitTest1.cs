using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTest_Bai17
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai17.csv", "DataBai17#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai17.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            short year = short.Parse(TestContext.DataRow[0].ToString());
            byte month = byte.Parse(TestContext.DataRow[1].ToString());
            byte day = byte.Parse(TestContext.DataRow[2].ToString());
            bool expected = bool.Parse(TestContext.DataRow[3].ToString());
            bool act = cls.IsValidDate(year, month, day);
            Assert.AreEqual(expected, act);
        }
    }
}

using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTest_Bai02
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai2.csv", "DataBai2#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai2.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            int X = int.Parse(TestContext.DataRow[0].ToString());
            int Y = int.Parse(TestContext.DataRow[1].ToString());
            int Z = int.Parse(TestContext.DataRow[2].ToString());
            string expected = TestContext.DataRow[3].ToString();
            string actual = cls.CheckValues(X, Y, Z);
            Assert.AreEqual(expected, actual);
        }
    }
}

using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTest_Bai06
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai6.csv", "DataBai6#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai6.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            double sum = double.Parse(TestContext.DataRow[0].ToString());
            double count = double.Parse(TestContext.DataRow[1].ToString());
            double exp = double.Parse(TestContext.DataRow[2].ToString());
            double act = cls.Average(sum, count);
            Assert.AreEqual(exp, act);
        }
    }
}

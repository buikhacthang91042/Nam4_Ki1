using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTestBai19
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai19.csv", "DataBai19#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai19.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            short height = short.Parse(TestContext.DataRow[0].ToString());
            int weight = int.Parse(TestContext.DataRow[1].ToString());
            sbyte expected = sbyte.Parse(TestContext.DataRow[2].ToString());
            sbyte actual = cls.KiemTraChiSoCoThe(height, weight);
            Assert.AreEqual(expected, actual);
        }
    }
}

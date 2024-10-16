using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTest_Bai03
{
    [TestClass]
    public class UnitTest1
    {

        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai3.csv", "DataBai3#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai3.csv"), TestMethod]
        
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            double mean_act;
            int a = int.Parse(TestContext.DataRow[0].ToString());
            int b = int.Parse(TestContext.DataRow[1].ToString());
            int c = int.Parse(TestContext.DataRow[2].ToString());
            int max_exp = int.Parse(TestContext.DataRow[3].ToString());
            double mean_expected = double.Parse(TestContext.DataRow[4].ToString());
            int max_act = cls.MaxAndMean(a, b, c, out mean_act);
            Assert.AreEqual(max_exp, max_act);
            Assert.AreEqual(mean_expected, mean_act, 0.1);
        }
    }
}

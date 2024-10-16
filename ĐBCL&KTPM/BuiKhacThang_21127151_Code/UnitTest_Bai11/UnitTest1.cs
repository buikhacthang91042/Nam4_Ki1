using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTest_Bai11
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai11.csv", "DataBai11#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai11.csv"), TestMethod]
        public void TestMethod1()
        {

            Class1 cls = new Class1();
            float w = float.Parse(TestContext.DataRow["w"].ToString());
            float h = float.Parse(TestContext.DataRow["h"].ToString());
            float ww = float.Parse(TestContext.DataRow["ww"].ToString());
            float wh = float.Parse(TestContext.DataRow["wh"].ToString());
            string expectedResult = TestContext.DataRow["expected_result"].ToString();
            string actualResult = cls.CalculatePosition(w, h, ww, wh);
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}

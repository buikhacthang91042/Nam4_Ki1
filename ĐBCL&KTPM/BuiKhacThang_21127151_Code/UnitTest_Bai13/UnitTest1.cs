using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTest_Bai13
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai13.csv", "DataBai13#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai13.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            float x1 = float.Parse(TestContext.DataRow["x1"].ToString());
            float y1 = float.Parse(TestContext.DataRow[1].ToString());
            float x2 = float.Parse(TestContext.DataRow[2].ToString());
            float y2 = float.Parse(TestContext.DataRow[3].ToString());
            float x = float.Parse(TestContext.DataRow[4].ToString());
            float y = float.Parse(TestContext.DataRow[5].ToString());
            string expected = TestContext.DataRow[6].ToString();
            string actual = cls.KiemTraDiemNamTrongHinhChuNhat(x1, y1, x2, y2, x, y);
            Assert.AreEqual(expected, actual);
        }
    }
}

using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace TestBai08
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data08.csv", "data08#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("data08.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int chiSoCu = Convert.ToInt32(TestContext.DataRow[0].ToString());
            int chiSoMoi = Convert.ToInt32(TestContext.DataRow[1].ToString());
            double expected = Convert.ToDouble(TestContext.DataRow[2].ToString());
            double act = o.TinhTienDien(chiSoCu,chiSoMoi);
            Assert.AreEqual(expected, act);
        }
    }
}

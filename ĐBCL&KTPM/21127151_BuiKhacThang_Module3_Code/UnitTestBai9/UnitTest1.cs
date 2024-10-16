using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTestBai9
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai9.csv", "DataBai9#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai9.csv"), TestMethod]
        public void TestMethod1()
        {

            Class1 cls = new Class1();
            float a = float.Parse(TestContext.DataRow[0].ToString());
            float b = float.Parse(TestContext.DataRow[1].ToString());
            float x = float.Parse(TestContext.DataRow[2].ToString());
            string expected = TestContext.DataRow[3].ToString();
            string actual = cls.Bai9(a, b, x); 
            Assert.AreEqual(expected, actual);
        }
        }
    }
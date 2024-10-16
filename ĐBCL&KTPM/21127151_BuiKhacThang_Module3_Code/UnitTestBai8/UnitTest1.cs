using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ClassLibrary_Module03;
namespace UnitTestBai8
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataBai8.csv", "DataBai8#csv",
        DataAccessMethod.Sequential),
        DeploymentItem("DataBai8.csv"), TestMethod]
        public void TestMethod1()
        {
            Class1 cls = new Class1();
            float a = float.Parse(TestContext.DataRow[0].ToString());
            float b = float.Parse(TestContext.DataRow[1].ToString());
            float c = float.Parse(TestContext.DataRow[2].ToString());
            string expected = TestContext.DataRow["expected_result"].ToString();
            string actual = cls.PhuongTrinhBac2(a, b, c);

            Assert.AreEqual(expected, actual);
        }
            }
    }


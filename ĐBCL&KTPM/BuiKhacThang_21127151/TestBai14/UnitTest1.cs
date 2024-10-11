using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace TestBai14
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data14.csv", "data14#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("data14.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();

        }
    }
}

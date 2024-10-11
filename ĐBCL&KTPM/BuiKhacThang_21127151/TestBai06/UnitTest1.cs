﻿using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace TestBai06
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data06.csv", "data06#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("data06.csv")]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int a =Convert.ToInt32(TestContext.DataRow[0].ToString());
            int b = Convert.ToInt32(TestContext.DataRow[1].ToString());
            int c = Convert.ToInt32(TestContext.DataRow[2].ToString());
            String expected = TestContext.DataRow[3].ToString();
            String act = o.Triangle(a, b, c);
            Assert.AreEqual(expected, act);
        }
    }
}

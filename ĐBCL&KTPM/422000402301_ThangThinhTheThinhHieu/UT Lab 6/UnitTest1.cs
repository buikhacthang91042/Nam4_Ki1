using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace UT_Lab_6
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }
        
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
            @"|DataDirectory|\\Data_UTLab6.csv", "Data_UTLab6#csv", DataAccessMethod.Sequential)]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1 = TestContext.DataRow[0].ToString();
            String s2 = TestContext.DataRow[1].ToString();
            String s3 = TestContext.DataRow[2].ToString();
            String expectedResult = TestContext.DataRow[3].ToString();
            String actual = o.ThayThe(s1, s2, s3);
            Assert.AreEqual(expectedResult, actual);
        }

       
        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
            @"|DataDirectory|\\DataError_UTLab6.csv", "DataError_UTLab6#csv", DataAccessMethod.Sequential)]
        public void TestMethod2()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1 = TestContext.DataRow[0].ToString();
            String s2 = TestContext.DataRow[1].ToString();
            String s3 = TestContext.DataRow[2].ToString();
            String expectedResult = TestContext.DataRow[3].ToString();

            try
            {
                String actual = o.ThayThe(s1, s2, s3);
                // Nếu không có lỗi, kiểm tra kết quả
                if (expectedResult == "Ném lỗi")
                {
                    Assert.Fail("Expected an exception but none was thrown.");
                }
                Assert.AreEqual(expectedResult, actual);
            }
            catch (Exception e)
            {
                // Kiểm tra xem có phải là trường hợp mong đợi không
                if (expectedResult != "Ném lỗi")
                {
                    Assert.Fail($"An unexpected exception was thrown: {e.Message}");
                }
                // Nếu là trường hợp mong đợi, không làm gì cả
            }
        }

    }
}

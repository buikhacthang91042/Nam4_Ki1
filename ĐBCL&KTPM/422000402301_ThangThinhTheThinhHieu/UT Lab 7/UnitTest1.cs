
using MethodLibrary;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using MethodLibrary;

namespace UT_Lab_7
{
    [TestClass]
    public class UnitTest1
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
               @"|DataDirectory|\\Data_UTLab7.csv", "Data_UTLab7#csv", DataAccessMethod.Sequential)]
        [TestMethod]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            string data = TestContext.DataRow[0].ToString();
            string expectedString = TestContext.DataRow[1].ToString();

            // Chuyển đổi giá trị expected từ chuỗi sang số nguyên
            int expected = int.Parse(expectedString);

            List<int> a = new List<int>();
            var elements = data.Trim(new char[] { '[', ']' }).Split(',')
                                               .Select(e => e.Trim())
                                               .ToList();

            foreach (var element in elements)
            {
                if (int.TryParse(element, out int number))
                {
                    a.Add(number);
                }
            }
            int[] array = a.ToArray();
            int actual = o.Largest(array);

            Assert.AreEqual(expected, actual);
        }


        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
            @"|DataDirectory|\\DataError_UTLab7.csv", "DataError_UTLab7#csv", DataAccessMethod.Sequential)]
        [TestMethod]
        public void TestMethod2()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            string data = TestContext.DataRow[0].ToString();
            

            Exception expectedException = null;

            try
            {
                List<int> a = new List<int>();
                var elements = data.Trim(new char[] { '[', ']' }).Split(',')
                                               .Select(e => e.Trim())
                                               .ToList();

                foreach (var element in elements)
                {
                    if (int.TryParse(element, out int number))
                    {
                        a.Add(number);
                    }
                }
                int[] array = a.ToArray();
                int actual = o.Largest(array);

               
            }
            catch (Exception ex)
            {
                expectedException = ex;
            }

            Assert.IsNotNull(expectedException);
            
        }

    }
}


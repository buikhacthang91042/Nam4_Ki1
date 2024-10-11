using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using MethodLibrary;
namespace UT_Lab_8
{
    [TestClass]
    public class UnitTest1
    {
         public TestContext TestContext { get; set; }

        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\Data_UTLab8.csv", "Data_UTLab8#csv", DataAccessMethod.Sequential)]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();

            string listString = TestContext.DataRow[0].ToString().Trim('[', ']');

            string[] stringElements = listString.Split(',');
            int[] list = new int[stringElements.Length];

            try
            {
                for (int i = 0; i < stringElements.Length; i++)
                {
                    string element = stringElements[i].Trim();
                    list[i] = int.Parse(element);
                }
            }
            catch (FormatException ex)
            {
                Assert.Fail($"Lỗi định dạng khi chuyển đổi phần tử của mảng: '{listString}'. Exception: {ex.Message}");
                return;
            }

            int left = int.Parse(TestContext.DataRow[1].ToString());
            int right = int.Parse(TestContext.DataRow[2].ToString());

            string expectedString = TestContext.DataRow[3].ToString().Trim('[', ']');
            string[] expectedElements = expectedString.Split(',');
            int[] expected = new int[expectedElements.Length];

            try
            {
                for (int i = 0; i < expectedElements.Length; i++)
                {
                    string expectedElement = expectedElements[i].Trim();
                    expected[i] = int.Parse(expectedElement);
                }
            }
            catch (FormatException ex)
            {
                Assert.Fail($"Lỗi định dạng khi chuyển đổi phần tử kết quả mong đợi: '{expectedString}'. Exception: {ex.Message}");
                return;
            }

            try
            {
                o.QuickSort(list, left, right);
                CollectionAssert.AreEqual(expected, list, "Mảng sau khi sắp xếp không khớp với kết quả mong đợi.");
            }
            catch (Exception ex)
            {
                Assert.Fail($"Xảy ra lỗi khi thực thi QuickSort: {ex.Message}");
            }
        }
        private bool AreIndicesValid(int left, int right, int listLength)
        {
            return left >= 0 && right >= 0 && left < listLength && right < listLength && left <= right;
        }
        [TestMethod()]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\DataError_UTLab8.csv", "DataError_UTLab8#csv", DataAccessMethod.Sequential)]
        [DeploymentItem("DataError_UTLab8.csv")]
        public void TestMethod2()
        {
            Exception expectedException = null;
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();

            try
            {
                string s = TestContext.DataRow[0].ToString();
                // Lấy dữ liệu từ TestContext
                string listString = s.Trim('[', ']');

                
                string[] stringElements = listString.Split(',');

                int[] list = new int[stringElements.Length];

              
                  
                // Chuyển đổi mảng string thành mảng int
                for (int i = 0; i < stringElements.Length; i++)
                {
                    string element = stringElements[i].Trim();
                    if (!string.IsNullOrWhiteSpace(element)) // Kiểm tra phần tử không rỗng
                    {
                        list[i] = int.Parse(element);
                    }
                }

                // Lấy giá trị của left và right
                int left = int.Parse(TestContext.DataRow[1].ToString());
                int right = int.Parse(TestContext.DataRow[2].ToString());

                // Kiểm tra danh sách rỗng
                if (list.Length == 0)
                {
                    throw new ArgumentException("Mảng không được bỏ trống");
                }

                // Kiểm tra chỉ số âm
                if (left < 0 || right < 0)
                {
                    throw new ArgumentException("left, right phải là số nguyên dương");
                }

                if (left > right)
                {

                    throw new ArgumentException("left phải bé hơn right");
                }

                if (string.IsNullOrEmpty(s))
                {
                    throw new ArgumentException("Không được bỏ trống các mảng, left, right");
                }

                    // Gọi phương thức QuickSort
                    o.QuickSort(list, left, right);
                Assert.Fail("Không có ngoại lệ nào được ném ra khi mong đợi.");
            }
            catch (ArgumentException ex)
            {
                expectedException = ex;
            }
            catch (IndexOutOfRangeException ex)
            {
                expectedException = new ArgumentException("left, right phải bé hơn độ dài mảng");
            }
            catch (FormatException ex)
            {
                expectedException = new ArgumentException("Mảng phải nhập số nguyên");
            }

            Assert.IsNotNull(expectedException);
        }

        private void if̣̣(bool v)
        {
            throw new NotImplementedException();
        }
    }
}

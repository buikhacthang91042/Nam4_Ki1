using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibrary_Module03
{
    public class Class1
    {
        public int getPositionOf2Cir(int firstRadius, int secRadius, int distance)
        {
            if (distance == 0)
            {
                if (firstRadius == secRadius)
                    return 0;
                else if (firstRadius < secRadius)
                    return 1;
                else
                    return 2;
            }
            else if (distance > 0)
            {
                return 3;
            }
            return -1;
        }

        public string CheckValues(int X, int Y, int Z)
        {
            if (X == 1 || X == 2)
            {
                return "A";
            }
            else
            {

                if (Y <= 10)
                {
                    return "B";
                }
                else
                {

                    if (Z < 5)
                    {
                        return "C";
                    }
                    else
                    {
                        return "D";
                    }
                }
            }
        }

        public int MaxAndMean(int A, int B, int C, out double Mean)
        {
            Mean = (A + B + C) / 3.0;
            int Maximum;
            if (A > B)
                if (A > C)
                    Maximum = A;
                else
                    Maximum = C;
            else if (B > C)
                Maximum = B;
            else
                Maximum = C;
            return Maximum;
        }

        public int Max(int a, int b, int c)
        {
            int max = 0;
            if (a > 0 && b > 0 && c > 0)
                max = a;
            else
                return 0;
            if (max < b)
                max = b;
            if (max < c)
                max = c;
            return max;
        }

        public string Triangle(int a, int b, int c)
        {
            int match = 0;
            if (a == b) match += 1;
            if (a == c) match += 2;
            if (b == c) match += 3;
            if (match == 0) { 
                if ((a + b) <= c)
                {
                    return "Not a Triangle";
                }else if ((b + c) <= a) {
                    return ("Not a Triangle");
                }else if ((a + c) <= b) {
                    return ("Not a Triangle");
                }else return ("Triangle is Scalene");
            }else if (match == 1) {
               if ((a + c) <= b) {
                   return ("Not a Triangle");
                }
                else return ("Triangle is Isosceles");
             }else if (match == 2) {
                if ((a + c) <= b) {
                    return ("Not a Triangle");
                }
                else return ("Triangle is Isosceles");
             }else if (match == 3) {
                if ((b + c) <= a) {
                    return ("Not a Triangle");
                }
                else return ("Triangle is Isosceles");
             }else return ("Triangle is Equilateral");
        }
    
    public double Average(double Sum, double Count)
        {
            if (Count == 1)
                return Sum;
            else if (Count > 0)
                return Sum / Count;
            else
                return 0;
        }

        public int DaysInMonth(int year, int month)
        {
            if (month < 1 || month > 12 || year < 0)
                return 0;
            switch (month)
            {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                case 2:
                    if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
                    {
                        return 29;
                    }
                    else
                        return 28;
                default:
                    return 0;
            }
        }

        public string PhuongTrinhBac2(float a, float b, float c)
        {
            if (a == 0)
            {
                return "Error"; 
            }

            float delta = b * b - 4 * a * c;

            if (delta < 0)
            {
                return "no results";
            }
            else if (delta == 0)
            {
                float x = -b / (2 * a);
                return $"{x},{x}"; 
            }
            else
            {
                float x1 = (float)((-b - Math.Sqrt(delta)) / (2 * a));
                float x2 = (float)((-b + Math.Sqrt(delta)) / (2 * a));
                return $"{x1},{x2}";
            }
        }



        public string Bai9(float a, float b, float x)
        {
            if (a > b)
                return "Error"; 
            else if (x < a)
                return $"{a}";
            else if (x > b)
                return $"{b}";
            else
                return $"{x}";
        }
        public bool EmailCheck(string email)
        {
            if (!email.Contains('.'))
            {
                return false;
            }
            if (email.Contains(".."))
            {
                return false;
            }
            int atCount = email.Split('@').Length - 1;
            if (atCount != 1)
            {
                return false;
            }
            if (email.Contains("@.") || email.Contains(".@") || email.Contains("@@"))
            {
                return false;
            }
            return true;
        }

        public sbyte KiemTraChiSoCoThe(short height, int weight)
        {
            if (height <= 0 || weight <= 0)
                return -1;

            float scale = weight * 10000 / (height * height);

            if (scale < 18)
                return 2;
            else
            {
                if (scale > 20)
                    return 1;
                else
                    return 0;
            }
        }


        private String str = "Statement Coverage";
        public int isInString(char tmp)
        {
            int MAX_INT = 32767; 
            int pos = MAX_INT;
            int i = 0;
            while (i < str.Length)
            {
                if (str[i] == tmp)
                {
                    pos = i; 
                    break;
                }
                i++;
            }

            return pos;
        }

        public string CalculatePosition(float w, float h, float ww, float wh)
        {
            if (w <= 0 || h <= 0 || ww <= 0 || wh <= 0)
            {
                return "Error";
            }

            float x, y;
            if (w > ww)
            {
                x = 0;
            }
            else
            {
                x = (ww - w) / 2;
            }
            if (h > wh)
            {
                y = 0;
            }
            else
            {
                y = (wh - h) / 2;
            }

            return $"{x},{y}";
        }
        public string TinhGiaNhieuMuc(double total, double p1, double p2, double p3)
        {
            double gia;
            if (p1 < 0 || p2 < 0 || p3 < 0 || total < 0)
            {
                return "Error";
            }
            if (total <= 100)
            {

                gia = total * p1;
                return $"{gia}";
            }
            else if (total <= 150)
            {
                gia = 100 * p1 + (total - 100) * p2;
                return $"{gia}";
            }
            else
            {
                gia = 100 * p1 + 50 * p2 + (total - 150) * p3;
                return $"{gia}";
            }
        }

        public string KiemTraDiemNamTrongHinhChuNhat(float x1, float y1, float x2, float y2, float x, float y)
        {
            bool kiemTra = false;
            if (x1 > x2 || y1 > y2)
            {
                return "Error";
            }
            else if (x < x1 || x > x2 || y < y1 || y > y2)
            {
                return $"{kiemTra}";
            }
            else
            {
                kiemTra = true;
                return $"{kiemTra}";
            };          
        }
        public string TaoMotIcon(float w, float h)
        {
            float x, y, s;
            if (w < 0 || h < 0)
            {
                return "Error";
            }
            else {
                if (w > h )
                {
                    x = (w - h) / 2;
                    y = 0;
                    s = h;
                    return $"{x},{y},{s}";
                }
                else
                {
                    y = (h - w) / 2;
                    x = 0;
                    s = w;
                    return $"{x},{y},{s}";
                };
            }
            
        }

        public bool IsValidTriangle(float a, float b, float c)
        {
            if (a <= 0 || b <= 0 || c <= 0)
            {
                return false;
            }
            if (a + b <= c)
            {
                return false;
            }
            if (a + c <= b)
            {
                return false;
            }
            if (b + c <= a)
            {
                return false;
            }
            return true;
        }


        public bool IsLeapYear(int year)
        {
            if (year > 10000 || year < 1000)
            {
                return false;
            }
            if (year % 100 == 0)
            {
                if (year % 400 == 0)
                {
                    return true;
                }
                else
                {
                    return false; 
                }
            }
            else if (year % 4 == 0)
            {
                return true; 
            }

            return false; 
        }

        public bool PasswordCheck(string password)
        {
            if (password.Length < 6 || password.Length > 10)
            {
                return false;
            }
            bool hasDigit = false;
            foreach (char c in password)
            {
                if (char.IsDigit(c))
                {
                    hasDigit = true;
                    break;
                }
            }
            return hasDigit;
        }
        public bool IsValidDate(short year, byte month, byte day)
        {
            if (month < 1 || month > 12)
            {
                return false;
            }
            if (day < 1)
            {
                return false;
            }
         
            int maxDays = DaysInMonth(year, month);
            if (day > maxDays)
            {
                return false; 
            }
            return true;
        }
      

        public int DaysInMonth(short year, byte month)
        {
            switch (month)
            {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                case 2:
                    
                    if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
                    {
                        return 29; 
                    }
                    else
                    {
                        return 28; 
                    }
                default:
                    return 0; 
            }
        }

        public long HexToDec(string hexaString)
        {
            int c;
            long hexnum,nhex;
            hexnum=nhex = 0;
            int i = 0;  
            while (i < hexaString.Length)
            {
                c = hexaString[i++];
                switch (c)
                {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        nhex++;
                        hexnum *= 0x10;
                        hexnum += (c - '0');
                        break;
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                        nhex++;
                        hexnum *= 0x10;
                        hexnum += (c - 'a'+ 0xa);
                        break;
                    case 'A':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                        nhex++;
                        hexnum *= 0x10;
                        hexnum += (c - 'A' + 0xA);
                        break;
                    default:
                        break;
                }
            }
            return hexnum;
        }

    }
}


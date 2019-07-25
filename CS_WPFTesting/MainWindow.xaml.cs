using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace CS_WPFTesting
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private string trueNum;
        public MainWindow()
        {
            InitializeComponent();
        }

        private void C1(object sender, RoutedEventArgs e)
        {
            trueNum += "1";
        }
        private void C2(object sender, RoutedEventArgs e)
        {
            trueNum += "2";
        }

        private void C3(object sender, RoutedEventArgs e)
        {
            trueNum += "3";
        }
        private void C4(object sender, RoutedEventArgs e)
        {
            trueNum += "4";
        }
        private void C5(object sender, RoutedEventArgs e)
        {
            trueNum += "5";
        }
        private void C6(object sender, RoutedEventArgs e)
        {
            trueNum += "6";
        }
        private void C7(object sender, RoutedEventArgs e)
        {
            trueNum += "7";
        }
        private void C8(object sender, RoutedEventArgs e)
        {
            trueNum += "8";
        }
        private void C9(object sender, RoutedEventArgs e)
        {
            trueNum += "9";
        }
        private void C0(object sender, RoutedEventArgs e)
        {
            trueNum += "0";
        }
        private void SHOWNUM(object sender, RoutedEventArgs e)
        {
            MessageBox.Show(trueNum);
        }
    }
}

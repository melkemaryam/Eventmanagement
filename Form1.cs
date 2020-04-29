using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void txtBoxPass_TextChanged(object sender, EventArgs e)
        {

        }

        private void lblPass_Click(object sender, EventArgs e)
        {

        }

        private void tabPage1_Click(object sender, EventArgs e)
        {

        }

        private void tabPage2_Click(object sender, EventArgs e)
        {

        }

        private void btnLogIn_Click(object sender, EventArgs e)
        {
            string validUser = "Cornelia";
            string validPassword = "pass";
            if (txtBoxUser.Text == validUser)
            {
                   if (txtBoxPass.Text == validPassword)
                   { 
                   Form6 mainform = new Form6();
                    mainform.ShowDialog();
                    this.Close();

                }
                else
                    MessageBox.Show("Incorrect Password", "Incorrect Password");
            }
            else
                MessageBox.Show("Incorrect Student ID", "Incorrect Student ID");

        }

        private void txtBoxUser_TextChanged(object sender, EventArgs e)
        {

        }

        private void tabControl1_Click(object sender, EventArgs e)
        {

        }

        private void btnRegister_Click(object sender, EventArgs e)
        {
            //if(txtBoxPassR.Text == txtBoxConfPass.Text) to do 
              //  MessageBox
            
        }

        private void txtBoxStName_TextChanged(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            txtBoxStFirstName.Text = "";
            txtBoxConfPass.Text = "";
            txtBoxPass.Text = "";
            txtBoxPassR.Text = "";
            txtBoxStLastName.Text = "";
            txtBoxUser.Text = "";
            textBox2.Text = "";



        }
    }
}

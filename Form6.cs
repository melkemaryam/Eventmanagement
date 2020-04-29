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
    public partial class Form6 : Form
    {
        int studenttype = 3;
        // 1=student; 2=organiser; 3=admin;/

        public Form6()
        {
            InitializeComponent();
        }

        private void Form6_Load(object sender, EventArgs e)
        {
            if(studenttype==1)
            { // this is for student
                createNewEventToolStripMenuItem.Visible = false;
                seeAllTheOrganizersToolStripMenuItem.Visible = false;
            }
            else if (studenttype==2)
            { // this is for orgaiser
                logOutToolStripMenuItem.Visible = false;
                seeAllTheOrganizersToolStripMenuItem.Visible = false;
            }
            else
            {// this is for admin
                logOutToolStripMenuItem.Visible = false;
            }
               
        }

        private void logOutToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }
    }
}

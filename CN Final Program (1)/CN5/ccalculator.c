/---------------------------------------------------------------
			Assignment No:5C
Write a program using TCP socket for wired network for following 
a. Say Hello to Each other ( For all students) 
b. File transfer ( For all students) 
c. Calculator (Arithmetic) 
d. Calculator (Trigonometry) 
Demonstrate the packets captured traces using Wireshark Packet Analyzer Tool for peer to peer mode
Name:Vedant Nandkumar Joshi
Roll No.:51
Batch:TEA-3
--------------------------------------------------------------*/

#include<sys/types.h>
#include<sys/socket.h>
#include<stdio.h>
#include<netinet/in.h> 
#include <unistd.h>
#include<string.h> 
#include<strings.h>
#include <arpa/inet.h>

//#define buffsize  150
void main()
{
int b,sockfd,sin_size,con,n,len;
//char buff[256];
char operator;
int op1,op2,result;
if((sockfd=socket(AF_INET,SOCK_STREAM,0))>0)
printf("socket created sucessfully\n");
//printf("%d\n", sockfd);
struct sockaddr_in servaddr;

servaddr.sin_family=AF_INET;
servaddr.sin_addr.s_addr=inet_addr("127.0.0.1");
servaddr.sin_port=6006;

sin_size = sizeof(struct sockaddr_in);
if((con=connect(sockfd,(struct sockaddr *) &servaddr, sin_size))==0); 
//initiate a connection on a socket
printf("connect sucessful\n");
printf("Enter operation:\n +:Addition \n -: Subtraction \n /: Division \n*:Multiplication \n");
scanf("%c",&operator);
printf("Enter operands:\n");
scanf("%d %d", &op1, &op2);

write(sockfd,&operator,10);
write(sockfd,&op1,sizeof(op1));
write(sockfd,&op2,sizeof(op2));
read(sockfd,&result,sizeof(result)); 
printf("Operation result from server=%d\n",result);  
close(sockfd);
}


/*************************OUTPUT*********************

gescoe@gescoe-OptiPlex-3020:~/Desktop/cn_prints$ gcc ccalculator.c
gescoe@gescoe-OptiPlex-3020:~/Desktop/cn_prints$ ./a.out
socket created sucessfully
connect sucessful
Enter operation:
 +:Addition 
 -: Subtraction 
 /: Division 
*:Multiplication 
+
Enter operands:
1 1
Operation result from server=2
*/

                                                                                                                                                                                 



















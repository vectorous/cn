*/----------------------------------------------------------------
			Assignment No:5D
Write a program using TCP socket for wired network for following 
a. Say Hello to Each other ( For all students) 
b. File transfer ( For all students) 
c. Calculator (Arithmetic) 
d. Calculator (Trigonometry) 
Demonstrate the packets captured traces using Wireshark Packet Analyzer Tool for peer to peer mode
Name:Vedant Nandkumar Joshi
Roll No.:51
Batch:TEA-3
---------------------------------------------------------------*/
#include<sys/types.h>
#include<sys/socket.h>
#include<stdio.h>
#include<netinet/in.h> 
#include <unistd.h>
#include<string.h> 
#include <arpa/inet.h>
#include<math.h>
#define PI 3.14159265
void main()
{
int b,sockfd,connfd,sin_size,l,n,len;
char op;
double angle1,a;

double result,val;

if((sockfd=socket(AF_INET,SOCK_STREAM,0))>0)
printf("socket created sucessfully\n");  //socket creation
//printf("%d\n", sockfd);                 //on success 0 otherwise -1

struct sockaddr_in servaddr;              
struct sockaddr_in clientaddr;

servaddr.sin_family=AF_INET;
servaddr.sin_addr.s_addr=inet_addr("127.0.0.1");
servaddr.sin_port=6666;

if((bind(sockfd, (struct sockaddr *)&servaddr,sizeof(servaddr)))==0)
printf("bind sucessful\n");   //bind() assigns the
     //  address  specified  by  addr  to  the  socket  referred  to by the file
      // descriptor sockfd.  addrlen  specifies  the  size,  in  bytes,  of  the
     //  address structure pointed to by addr.  Traditionally, this operation is
      // called �assigning a name to a socket�.

//printf("%d\n",b);

if((listen(sockfd,5))==0) //listen for connections on a socket
printf("listen sucessful\n");
//printf("%d\n",l);

sin_size = sizeof(clientaddr);
if((connfd=accept(sockfd,(struct sockaddr *)&clientaddr,&sin_size))>0);
printf("accept sucessful\n");
val = PI / 180;
read(connfd, &op,1);
//printf("\n op=%d",op);

read(connfd, &angle1, sizeof(angle1));
//printf("\n angle is=%lf \n",angle1);

switch(op) {
        case '1': result=sin(angle1*val);
         printf("sin(%lf)=%lf ",angle1,result);
         break;
        case '2':result=cos(angle1*val);
         printf("cos(%lf) =%lf ",angle1,result);
                break;
        case '3':result=tan(angle1*val);
         printf("tan(%lf) = %lf",angle1,result);
                break;
        
     default: 
                printf("ERROR: Unsupported Operation");
    }
  
write(connfd,&result,sizeof(result));

close(connfd);   
close(sockfd);
}

/*===================OUTPUT==================================
gescoe@gescoe-OptiPlex-3020:~$ cd Desktop
gescoe@gescoe-OptiPlex-3020:~/Desktop$ cd TEA22
gescoe@gescoe-OptiPlex-3020:~/Desktop/TEA51$ cd TCP
gescoe@gescoe-OptiPlex-3020:~/Desktop/TEA51/TCP$ gcc strignometry.c -lm
gescoe@gescoe-OptiPlex-3020:~/Desktop/TEA51/TCP$ ./a.out
socket created sucessfully
bind sucessful
listen sucessful
accept sucessful
sin(30.000000)=0.500000 
gescoe@gescoe-OptiPlex-3020:~/Desktop/TEA84/TCP$ 

===========================================================*/

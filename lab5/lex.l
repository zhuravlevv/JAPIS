%{

#include "bison.tab.h"
#include <stdio.h>

void showError();
%}

%%
","								{return(COMMA);}
";"								{return(SEMICOLON);}
"("								{return(L);}
")"								{return(R);}
[ \n\t]+						{/*ignore*/}
[-]?[XVI]+                 		{
									takeText();
									return(NUM);
								}
[a-zA-Z][a-zA-Z0-9_]*           {
									takeText();
									return(ID);
								}
.					   			{showError(); exit(0);}

%%

void takeText(){
	yylval.sval = malloc(strlen(yytext));
	strncpy(yylval.sval, yytext, strlen(yytext));
	yylval.sval[strlen(yytext)] = '\0';
}

void showError(){
	printf("Other input");
}

yywrap () {
  return (0);
}

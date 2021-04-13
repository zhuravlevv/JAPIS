%{

#include <stdio.h>

void yyerror (char const *);
  
%}
%union
{
	char *sval;
}

%token L
%token R
%token <sval> ID
%token <sval> NUM
%token <sval> PROCEDURE
%token SEMICOLON
%token COMMA

%start functions
%%

functions:			| functions function
					;
function:           ID L {printf("\nProcedure name: %s\n", $1);}
					full_params
					R
					SEMICOLON
 					;
full_params:		/* empty */
					| params identifier
					;
params:          	/* empty */
					| params param
					;
param:        		identifier COMMA
					;
identifier:			ID {printf("Identifier : %s\n", $1);}
					| NUM {printf("Roman number : %s\n", $1);}
					;
%%

extern char *yytext;

void yyerror (char const *s)
{
	printf("Error: %s. After lexema:%s\n", s, yytext);
}


main (void) {
	while(1){
		printf("Enter text: ");
    	yyparse();
    }
    return 0;
}

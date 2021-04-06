%{
#include <stdio.h>
#include <string.h>
#include "bison.tab.h"

void showError();
%}

%%
[a-zA-Z]+              {printf("identificator\n");return(ID);}
[0-9]+                 {printf("INT\n");return(INT);}
.					   {showError(); exit(0);}

%%

void showError(){
	printf("Other input");
}

yywrap () {
  return (0);
}

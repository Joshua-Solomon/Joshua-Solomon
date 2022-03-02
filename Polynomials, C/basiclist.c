/* Very basic linked list example */
#include <stdio.h>
#include <stdlib.h>
#include"basiclist.h"

int list_add(node_t ** list, void * data) {
  int ret = 0;
  node_t * newnode = (node_t *) malloc(sizeof(node_t));
  if (newnode == NULL) {
    ret = -1;
  }
  else {
    newnode->data = data;
    newnode->next = *list;
    *list = newnode;
  }
  return ret;
}

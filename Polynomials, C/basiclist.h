/* Very basic linked list*/
#ifndef BASICLIST_H
#define BASICLIST_H

typedef struct node {
  void * data;         /* pointer to data */
  struct node * next;  /* pointer to next next node */
} node_t;

int list_add(node_t ** list, void * data);

#endif

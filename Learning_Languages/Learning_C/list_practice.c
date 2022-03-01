#include <stdio.h>
#include <stdlib.h>
#include"basiclist.h"
 
/*Sample output:
Points:
  (-2, 7)
  (-5, 3)
  (0, 4)
  (-1, 3)
*/

typedef struct {
  int x;
  int y;
} point_t;
 
int main(void) {
  node_t * list = NULL;
  node_t * curr;
 
  point_t p1 = {-1, 3};
  point_t p2 = {0, 4};
  point_t * p3 = (point_t *) malloc(sizeof(point_t));
  p3->x = -5;
  p3->y = 3;
  point_t * p4 = (point_t *) malloc(sizeof(point_t));
  p4->x = -2;
  p4->y = 7;
 
  list_add(&list, &p1);
  list_add(&list, &p2);
  list_add(&list, p3);
  list_add(&list, p4);
 
  curr = list;
 
  printf("Points:\n");
  while (curr != NULL) {
	point_t * this_point = (point_t *) curr->data;
	printf("  (%d, %d)\n", this_point->x, this_point->y);
	curr = curr->next;
  }
  return 0;
}

/*basiclist.c (in Polynomials, C folder):
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
*/

/*basiclist.h (in Polynomials, C folder):
#ifndef BASICLIST_H
#define BASICLIST_H

typedef struct node {
  void * data;        
  struct node * next; 
} node_t;

int list_add(node_t ** list, void * data);
#endif
*/

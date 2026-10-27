from fastapi import APIRouter, HTTPException, status

router = APIRouter(prefix="/products", tags=["products"])

@router.get("/{product_id}")
def get_product(product_id:int)-> dict:
    return { "id": product_id, "name": "컴퓨터"}

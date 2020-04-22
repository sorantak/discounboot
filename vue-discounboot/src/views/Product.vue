<template>
<div>
    <p>This is Details of a Product.</p>
    <p>name</p>
    <p>thumbnail</p>
    <p>original price</p>
    <p>discounted price</p>
    <p>description</p>
    <button>BASKET</button>
    <Detail></Detail>
</div>
</template>

<script>
import Detail from '@/components/Detail.vue'

export default {
    components: {
        Detail
    }
}
</script>

<style>

</style>